#version 110

uniform sampler2D DiffuseSampler;
uniform sampler2D BlurSampler;

varying vec2 texCoord;
varying vec2 oneTexel;

uniform vec2 InSize;

uniform vec2 BlurDir;
uniform float Radius;

void main() {
    vec4 blurTexel = texture2D(BlurSampler, texCoord);

    vec4 blurred = vec4(0.0);
    float totalStrength = 0.0;
    float totalAlpha = 0.0;
    float totalSamples = 0.0;

    for(float r = -Radius; r <= Radius; r += 1.0) {
        vec4 sampleValue = texture2D(DiffuseSampler, texCoord + oneTexel * r * BlurDir);

		// Accumulate average alpha
        totalAlpha = totalAlpha + sampleValue.a;
        totalSamples = totalSamples + 1.0;

		// Accumulate smoothed blur
        float strength = 1.0 - abs(r / Radius);
        totalStrength = totalStrength + strength;
        blurred = blurred + sampleValue;
    }

	vec4 blurredColor = vec4(blurred.rgb / (Radius * 2.0 - 1.0), totalAlpha);
	vec4 outColor = mix(blurTexel, blurredColor, 0.05);

	gl_FragColor = vec4(outColor.rgb, outColor.a * 0.5);
}
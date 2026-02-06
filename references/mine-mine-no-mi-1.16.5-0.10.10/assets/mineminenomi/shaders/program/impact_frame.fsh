#version 110

uniform sampler2D DiffuseSampler;

varying vec2 texCoord;
varying vec2 oneTexel;

uniform vec2 InSize;

void main() {
	vec4 sampleValue = texture2D(DiffuseSampler, texCoord + oneTexel);

	float gray = (sampleValue.r + sampleValue.g + sampleValue.b) * 0.33;
	float luma = mix(0.0, 1.0, step(0.40, gray));
	vec4 outColor = vec4(luma, luma, luma, 1.0);

	gl_FragColor = outColor;
}
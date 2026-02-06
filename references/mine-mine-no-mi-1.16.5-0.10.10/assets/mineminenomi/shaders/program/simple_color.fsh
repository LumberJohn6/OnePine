#version 110

uniform sampler2D DiffuseSampler;

varying vec2 texCoord;
varying vec2 oneTexel;

uniform vec2 InSize;
uniform vec4 Color;

void main() {
	vec4 sampleValue = texture2D(DiffuseSampler, texCoord + oneTexel);

	float redValue = sampleValue.r * Color.r;
	float greenValue = sampleValue.g * Color.g;
	float blueValue = sampleValue.b * Color.b;
	float alphaValue = sampleValue.a * Color.a;
	vec4 outColor = vec4(redValue, greenValue, blueValue, alphaValue);

	gl_FragColor = outColor;
}
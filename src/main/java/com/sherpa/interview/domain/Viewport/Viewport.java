package com.sherpa.interview.domain.Viewport;

import lombok.Builder;

@Builder
public record Viewport(int x, int y, int zoom) {
}

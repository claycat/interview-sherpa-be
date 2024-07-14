package com.sherpa.interview.domain.viewport;

import lombok.Builder;

@Builder
public record Viewport(int x, int y, int zoom) {
}

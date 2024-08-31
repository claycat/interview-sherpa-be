package com.sherpa.flow.domain.Viewport;

import lombok.Builder;

@Builder
public record Viewport(int x, int y, int zoom) {
}

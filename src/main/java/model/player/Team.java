package model.player;

import java.util.Arrays;

public enum Team {
    RED,
    GREEN;

    public static Team findByName(final String name) {
        return Arrays.stream(values())
                .filter(team -> team.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("팀 이름이 잘못되었습니다."));
    }

    public Team getOtherTeam() {
        if (this == RED) {
            return GREEN;
        }
        return RED;
    }
}

package christmas.constant;


public enum ChristmasBadge {
    SANTA("산타", 20000) {
        @Override
        public String getBadgeByValue(int value) {
            if (value >= 20000) {
                return SANTA.name;
            }
            return null;
        }
    },
    STAR("별", 10000) {
        @Override
        public String getBadgeByValue(int value) {
            if (value >= 5000 && value < 10000) {
                return STAR.name;
            }
            return null;
        }
    },
    TREE("트리", 5000) {
        @Override
        public String getBadgeByValue(int value) {
            if (value >= 10000 && value < 20000) {
                return TREE.name;
            }
            return null;
        }
    },
    NONE("없음", 0) {
        @Override
        public String getBadgeByValue(int value) {
            return NONE.name;
        }
    };

    private final int value;
    private final String name;

    ChristmasBadge(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract String getBadgeByValue(int value);

    public static String getBadge(int value) {
        for (ChristmasBadge badge : ChristmasBadge.values()) {
            String result = badge.getBadgeByValue(value);
            if (result != null) {
                return result;
            }
        }
        return NONE.name;
    }
}
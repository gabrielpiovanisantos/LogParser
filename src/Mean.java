import java.util.HashMap;
import java.util.Map;

public enum Mean {
    MOD_UNKNOWN(1),
    MOD_SHOTGUN(2),
    MOD_GAUNTLET(2),
    MOD_MACHINEGUN(3),
    MOD_GRENADE(4),
    MOD_GRENADE_SPLASH(5),
    MOD_ROCKET(6),
    MOD_ROCKET_SPLASH(7),
    MOD_PLASMA(8),
    MOD_PLASMA_SPLASH(9),
    MOD_RAILGUN(10),
    MOD_LIGHTNING(11),
    MOD_BFG(12),
    MOD_BFG_SPLASH(13),
    MOD_WATER(15),
    MOD_SLIME(16),
    MOD_LAVA(17),
    MOD_CRUSH(18),
    MOD_TELEFRAG(19),
    MOD_FALLING(20),
    MOD_SUICIDE(21),
    MOD_TARGET_LASER(22),
    MOD_TRIGGER_HURT(23),
    MOD_NAIL(24),
    MOD_CHAINGUN(25),
    MOD_PROXIMITY_MINE(26),
    MOD_KAMIKAZE(27),
    MOD_JUICED(28),
    MOD_GRAPPLE(29), 
    UNKNOWN(0);

    private final Integer id;

    Mean(Integer i) {
        this.id = --i;
    }

    private static final Map<Long, Mean> byId = new HashMap<Long, Mean>();

    public static Mean getById(Integer id) {
        for(Mean e : values()) {
            if(e.id.equals(id)) return e;
        }
        return UNKNOWN;
    }
}

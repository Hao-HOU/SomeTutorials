package spittr.data;

import spittr.domain.Spitter;

/**
 * Created by Hao HOU on 2017/6/8.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}

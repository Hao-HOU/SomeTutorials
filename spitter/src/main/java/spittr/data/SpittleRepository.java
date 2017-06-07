package spittr.data;

import spittr.domain.Spittle;

import java.util.List;

/**
 * Created by Hao HOU on 2017/6/7.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    List<Spittle> findRecentSpittles();
    Spittle findOne(long id);
    void save(Spittle spittle);
}

package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.domain.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Hao HOU on 2017/6/7.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {
    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id < ?" +
                        " order by created_at desc limit ?",
                new SpittleRowMapper(),
                max,
                count
        );
    }

    @Override
    public List<Spittle> findRecentSpittles() {
        return jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper()
        );
    }

    @Override
    public Spittle findOne(long id) {
        try {
            return jdbc.queryForObject(
                    "select id, message, created_at, latitude, longitude" +
                            " from Spittle" +
                            " where id = ?",
                    new SpittleRowMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            String message = e.getMessage();
            return new Spittle(message,new Date());
        }
    }

    @Override
    public void save(Spittle spittle) {
        jdbc.update(
                "insert into Spittle (message, created_at, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude()
        );
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {
        @Override
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"));
        }
    }
}

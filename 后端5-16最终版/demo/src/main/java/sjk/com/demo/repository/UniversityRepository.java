package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sjk.com.demo.entity.Universities;

import java.util.List;
public interface UniversityRepository extends JpaRepository<Universities, Long> {
    @Query("SELECT u FROM Universities u WHERE " +
            "(:minFee IS NULL OR u.minFee >= :minFee) AND " +
            "(:maxFee IS NULL OR u.maxFee <= :maxFee) AND " +
            "(:type IS NULL OR u.type = :type) AND " +
            "(:province IS NULL OR u.province = :province) AND " +
            "(:city IS NULL OR u.city = :city)")
    List<Universities> findFilteredUniversities(@Param("minFee") Double minFee,
                                                @Param("maxFee") Double maxFee,
                                                @Param("type") String type,
                                                @Param("province") String province,
                                                @Param("city") String city);

    Universities findByName(String name);
    void deleteByName(String name);


}

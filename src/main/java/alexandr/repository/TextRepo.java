package alexandr.repository;

import alexandr.enitis.Text;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TextRepo extends JpaRepository<Text, Long> {

}

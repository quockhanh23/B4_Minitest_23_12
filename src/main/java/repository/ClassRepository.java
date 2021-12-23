package repository;

import model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classes, Long> {
}

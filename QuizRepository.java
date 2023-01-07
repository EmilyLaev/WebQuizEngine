+package engine.repository;


import engine.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Quiz entity
// No need to define any additional methods, since the basic CRUD operations
// (save, findById, delete, etc.) are already provided by JpaRepository.
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

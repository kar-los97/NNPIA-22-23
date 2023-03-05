package cz.upce.nnpia.cv01.repository;

import cz.upce.nnpia.cv01.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}

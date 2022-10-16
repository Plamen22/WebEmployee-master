package net.codejava.repository;

import net.codejava.models.WorkerSchedule;
import org.springframework.data.repository.CrudRepository;

public interface WorkerScheduleRepository extends CrudRepository<WorkerSchedule, Long> {
}

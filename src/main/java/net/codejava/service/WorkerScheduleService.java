package net.codejava.service;

import net.codejava.models.WorkerSchedule;
import net.codejava.repository.WorkerScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
@Service
public class WorkerScheduleService {

    private WorkerScheduleRepository workerScheduleRepository;

    public WorkerScheduleService(WorkerScheduleRepository workerScheduleRepository) {
        this.workerScheduleRepository = workerScheduleRepository;
    }

    public Iterable<WorkerSchedule> findAll() {
        return workerScheduleRepository.findAll();
    }

    public boolean existsById(long id) {
        return workerScheduleRepository.existsById(id);
    }

    public Optional<WorkerSchedule> findById(long id) {
        return workerScheduleRepository.findById(id);
    }

    public WorkerSchedule save(WorkerSchedule workerSchedule) {
        return workerScheduleRepository.save(workerSchedule);
    }

    public WorkerSchedule updateWithPartialDate(long id, WorkerSchedule updateInfo) {

        Optional<WorkerSchedule> workerScheduleFind = findById(id);

        WorkerSchedule  workerScheduleToUpdate = workerScheduleFind.get();

        if (updateInfo.getMonday() != null && updateInfo.getMonday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setMonday(updateInfo.getMonday());
        }
        if (updateInfo.getTuesday() != null && updateInfo.getTuesday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setTuesday(updateInfo.getTuesday());
        }
        if (updateInfo.getWednesday() != null && updateInfo.getWednesday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setWednesday(updateInfo.getWednesday());
        }
        if (updateInfo.getThursday() != null && updateInfo.getThursday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setThursday(updateInfo.getThursday());
        }
        if (updateInfo.getFriday() != null && updateInfo.getFriday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setFriday(updateInfo.getFriday());
        }
        if (updateInfo.getSaturday() != null && updateInfo.getSaturday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setSaturday(updateInfo.getSaturday());
        }
        if (updateInfo.getSunday() != null && updateInfo.getSunday().length() > 0) { // if the request has a name param
            workerScheduleToUpdate.setSunday(updateInfo.getSunday());
        }

        return workerScheduleRepository.save(workerScheduleToUpdate);
    }

    public void deleteById(long id) {
        workerScheduleRepository.deleteById(id);
    }


}

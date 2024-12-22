package ws.RestService;

import Model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
    Admission findByPatientNameAndRoomNumber(String name, int roomNumber);
}

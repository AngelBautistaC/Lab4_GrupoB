package com.example.lab4_20222.repositories;

import com.example.lab4_20222.dto.ServiciosMascotaDto;
import com.example.lab4_20222.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(nativeQuery = true,value = "select m.nombre as 'nombremascota',m.anho as 'edad', s.hora_inicio as 'horainicio', s.duracion as 'duracion',\n" +
            "            s.entrega as 'entrega', r.nombre as 'responsable', o.descripcion as 'servicio' from servicio s \n" +
            "            join opcion_servicio os on (s.idservicio = os.servicio_idservicio)\n" +
            "            join opcion o on (o.idopcion=os.opcion_idopcion)\n" +
            "            join responsable r on (s.responsable_idresponsable = r.idresponsable)\n" +
            "            join mascota m on ( m.idmascota=s.mascota_idmascota)\n" +
            "            where s.mascota_idmascota = ?1")
    List<ServiciosMascotaDto> listaServiciosMascota (Integer idmascota);
}

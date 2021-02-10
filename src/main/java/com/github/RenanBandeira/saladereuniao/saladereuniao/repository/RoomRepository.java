package com.github.RenanBandeira.saladereuniao.saladereuniao.repository;

import com.github.RenanBandeira.saladereuniao.saladereuniao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long> {
}

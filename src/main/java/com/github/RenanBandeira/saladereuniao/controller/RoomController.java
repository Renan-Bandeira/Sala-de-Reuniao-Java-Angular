package com.github.RenanBandeira.saladereuniao.controller;


import com.github.RenanBandeira.saladereuniao.execption.ResourceNotFoundException;
import com.github.RenanBandeira.saladereuniao.model.Room;
import com.github.RenanBandeira.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRoom() {
        return roomRepository.findAll();

    }

    @GetMapping("/rooms/{id}")

    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found::" + id));

        return ResponseEntity.ok().body(room);

    }

    @PostMapping("/rooms")
    public Room createRooms(@RequestBody @Valid Room room) {
        return roomRepository.save(room);

    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRooms(@PathVariable Long id, @RequestBody @Valid Room roomDetails) throws ResourceNotFoundException {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id::" + id));

        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStarHour(roomDetails.getStarHour());
        room.setEndHour(roomDetails.getEndHour());
        Room roomUpdate = roomRepository.save(room);

        return ResponseEntity.ok(roomUpdate);
    }

    @DeleteMapping
    public Map<String, Boolean>  deleteRoom(@PathVariable Long id) throws ResourceNotFoundException{

        Room room = roomRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found for this id::" + id));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

}

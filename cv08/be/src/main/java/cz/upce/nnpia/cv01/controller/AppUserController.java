package cz.upce.nnpia.cv01.controller;

import cz.upce.nnpia.cv01.entity.AppUser;
import cz.upce.nnpia.cv01.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/app-user")
public class AppUserController {

    public final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/:id")
    public ResponseEntity<?> getUserById(@RequestParam Integer id){
        try{
            AppUser user = appUserRepository.getReferenceById(id);
            return ResponseEntity.ok(user);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody AppUser appUser){
        try {
            AppUser created = appUserRepository.save(appUser);
            return ResponseEntity.ok(created);
        }catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/:id")
    public ResponseEntity<?> updateUser(@RequestParam Integer id, @RequestBody AppUser appUser){
        try{
            AppUser userToUpdate = appUserRepository.getReferenceById(id);
            userToUpdate.setUsername(appUser.getUsername());
            userToUpdate.setPassword(appUser.getPassword());
            userToUpdate.setUpdateDate(appUser.getUpdateDate());
            userToUpdate.setActive(appUser.isActive());
            userToUpdate = appUserRepository.save(userToUpdate);
            return ResponseEntity.ok(userToUpdate);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/:id")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id){
        try{
            AppUser userToDelete = appUserRepository.getReferenceById(id);
            appUserRepository.delete(userToDelete);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException ex){
            return ResponseEntity.badRequest().build();
        }
    }
}

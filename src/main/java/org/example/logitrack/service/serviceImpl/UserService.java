package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;

import org.example.logitrack.repository.UserRepository;
import org.example.logitrack.service.interfaces.UserInterface;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserInterface {
    private  final UserRepository userRepository;

    public long countUsers(){
        return userRepository.count();
    }






















//
//    public void  disableAccount(int id){
//        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("usser not found"));
//
//        if(user.getRole() == Role.ADMIN){
//            throw new RuntimeException("admin can't be disabled ");
//        }
//        user.setActive(false);
//        userRepository.save(user);
//    }

}

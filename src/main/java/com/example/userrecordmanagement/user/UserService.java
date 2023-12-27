package com.example.userrecordmanagement.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
		return userRepository.findAll();
	}

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void partialUpdateUser(Long userId, Map<String, Object> updates) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " doesn't exist.");
        }
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            applyPartialUpdates(existingUser, updates);
            userRepository.save(existingUser);
        }
        
    }

    private void applyPartialUpdates(User user, Map<String, Object> updates) {
        updates.forEach((key, value) -> {
            switch (key) {
                case "about":
                    user.setAbout((String) value);
                    break;
                case "roles":
                    user.setRoles((String) value);
                    break;
                case "language":
                    user.setLanguage((List<String>) value);
                    break;
                case "skills":
                    user.setSkills((List<String>) value);
                    break;
                case "projectsAndExperiences":
                    user.setProjectsAndExperiences((List<String>) value);
                    break;
                case "assignments":
                    user.setAssignments((List<String>) value);
                    break;
                case "pfp":
                    user.setPfp((String) value);
                    break;
            }
        });
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " doesn't exist.");
        }
        userRepository.deleteById(userId);
    }

}
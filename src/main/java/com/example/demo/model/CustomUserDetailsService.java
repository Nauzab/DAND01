package com.example.demo.model;


/*import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repo.AdministratorRepo;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.repo.RunnerRepo;




@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdministratorRepo adminRepo;
    @Autowired
    private RunnerRepo runnerRepo;
    
    @Autowired
    private ManagerRepo managerRepo;
    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
    	
        Administrator admin = adminRepo.findAdministratorByEmail(email);
        if (admin != null) {
            return new CustomUserDetails(admin.getEmail(), admin.getPassword(), "Admin");
        } 
        
        
        Manager manager = managerRepo.findByEmail(email);
        if(manager != null) {
        	return new CustomUserDetails(manager.getEmail(), manager.getPassword(), "Manager");
        }
        
        Runner runner = runnerRepo.findByEmail(email);
        if(runner != null) {
          
              return new CustomUserDetails(runner.getEmail(), runner.getPassword(), "Runner");
        }
        
       
        
        throw new UsernameNotFoundException("User email - '" + email + "' - not found");
    }

    public class CustomUserDetails implements UserDetails {

        private String surname;
        private String password;
        private String authorities;

        public CustomUserDetails() {
            super();
        }

        public CustomUserDetails(String email, String password, String role) {
            this.surname= email;
            this.password = password;
            this.authorities = role;
        }

        public String getAuthorities1() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }


        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {		
			return surname;
		}



	

    }

}*/
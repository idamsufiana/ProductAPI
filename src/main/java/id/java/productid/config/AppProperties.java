package id.java.productid.config;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class AppProperties {

    
    String in = "in";
    String out = "out";
    String Admin = "ADMIN";
    String Pegawai = "PEGAWAI";
    String absensi = "absensi";
    String email = "email";
    String password = "password";
    String profile = "profile";
    String jabatan = "jabatan";
    String departemen = "departemen";
    String unitKerja = "unit-kerja";
    String pendidikan = "pendidikan";
    String jeniskelamin = "jenis-kelamin";
    String departemenhrd = "departemen-hrd";
    String Success = "Success";
    String WrongPass = "Salah Password";
    String UserTaken = "User Already Taken";
    String EmailExist = "Email Already Exist";
    String SuccessReg = "Success registered";
    String SignOut = "Ok Sign Out";
    String RoleNotfound = "Role is not found";
}

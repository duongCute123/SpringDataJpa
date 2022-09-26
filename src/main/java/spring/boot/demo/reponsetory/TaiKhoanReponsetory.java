package spring.boot.demo.reponsetory;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.demo.model.TaiKhoan;

public interface TaiKhoanReponsetory extends JpaRepository<TaiKhoan, String>{

}

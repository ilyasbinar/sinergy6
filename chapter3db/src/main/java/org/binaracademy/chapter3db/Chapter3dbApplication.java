package org.binaracademy.chapter3db;

import org.binaracademy.chapter3db.controller.KaryawanController;
import org.binaracademy.chapter3db.model.Karyawan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Chapter3dbApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(Chapter3dbApplication.class, args);
		KaryawanController karyawanController = context.getBean(KaryawanController.class);
		karyawanController.initiateData();
//		karyawanController.deleteAll();
//		karyawanController.home();

		/**
		 * Demo tambah detail karyawan.
		 * 1. pastikan karyawanController.initiateData()
		 * 		sudah di run terlebih dahulu untuk mempopulasi data
		 * 2. uncomment statement dibawah untuk menambah detail karwayan dengan karyawan id=2
 		 */
//		karyawanController.addDetail(2l);
	}

}

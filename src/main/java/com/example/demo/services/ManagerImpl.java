package com.example.demo.services;

import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.email.EmailSender;
import com.example.demo.model.Manager;

import com.example.demo.model.Marathon;
import com.example.demo.repo.ManagerRepo;
import com.example.demo.repo.MarathonRepo;
import com.example.demo.repo.RunnerRepo;

import com.example.demo.repo.ManagerRepo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class ManagerImpl implements ManagerService {

	@Autowired
	ManagerRepo managerRepo;

	@Autowired
	RunnerRepo runnerRepo;

	@Autowired
	MarathonRepo marathonRepo;
	
	@Autowired
    private EmailSender notificationService;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ArrayList<Manager> selectAll() {
		ArrayList<Manager> tempList = new ArrayList<Manager>();
		for (Manager m : managerRepo.findAll()) {
			tempList.add(m);
		}
		return tempList;
	}

	@Override
	public boolean updateManager(Manager manager) {
		Manager manToFind = managerRepo.findByEmail(manager.getEmail());
		System.out.println(manToFind.getId());
		if (manToFind != null && managerRepo.existsById(manToFind.getId())) {
			
			manToFind.setName(manager.getName());
			manToFind.setSurname(manager.getSurname());
			manToFind.setEmail(manager.getEmail());
			manToFind.setPassword(manager.getPassword());
			managerRepo.save(manToFind);
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteRunnerById(int id_r) {
		if (id_r > -1 && runnerRepo.existsById(id_r)) {

			runnerRepo.deleteById(id_r);
			return true;
		} else
			return false;
	}

	@Override
	public boolean authorizeManager(String email, String password) {
		Manager man = managerRepo.findByEmailAndPassword(email, password);
		if (man != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean createNewMarathon(Marathon marathon) {
		if (marathon == null && marathonRepo.existsById(marathon.getId()))
			return false;
		else {
			marathonRepo.save(marathon);
			return true;
		}
	}

	@Override
	public boolean insertNewManager(Manager manager) {
		if (manager == null || managerRepo.existsById(manager.getId()))
			return false;
		else {
			managerRepo.save(manager);
			
		}
		return true;
	}

	@Override
	public boolean exportDataExcel() {
		final String FILE_NAME = "MarathonExcel.xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Marathon info");

		ArrayList<Marathon> tempList = new ArrayList<Marathon>();
		for (Marathon m : marathonRepo.findAll()) {
			tempList.add(m);
			int rowNum = 1;
			System.out.println("Creating excel");

			for (int i = 1; i <= tempList.size(); i++) {
				Marathon maratoni1 = tempList.get(i - 1);
				Row row = sheet.createRow(rowNum);
				int colNum = 0;

				Cell cell = row.createCell(colNum);
				cell.setCellValue(maratoni1.getName());
				Cell cell2 = row.createCell(colNum);
				cell2.setCellValue(maratoni1.getPlace());
				rowNum++;
			}
		}
			try {
				FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
				workbook.write(outputStream);
				workbook.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
								
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			System.out.println("Done");

			return true;
	}

	@Override
	public int findManagerId(String email) {
		Manager manager = managerRepo.findByEmail(email);
		if (manager != null) {
			return manager.getId();
		}
		
		return -1;
	}

	@Override
	public Manager findByID(int id) throws Exception {
		Manager manager = managerRepo.findById(id).get();
		
		if (manager != null) 
			return manager;
		
		throw new Exception("Manager not found by Id");
	}

	@Override
	public Manager findByEmail(String email) {
		Manager manager = managerRepo.findByEmail(email);
		if(manager != null)
			return manager;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendRegistrationEmail(String email){
		EmailSender sendEmailToSender = new EmailSender(javaMailSender);
		try {
			sendEmailToSender.sendEmail(email);
			sendEmailToSender.sendEmailWithAttachment(email);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException m) {
			m.printStackTrace();
		}
		
		 
		/*SimpleMailMessage message = new SimpleMailMessage();
         
	        message.setTo(email) ;
	        message.setSubject("Test Simple Email");
	        message.setText("Hello, Im testing Simple Email");
	  */

	        }// TODO Auto-generated method stub
		
	}

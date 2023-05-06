package com.gestion.etablissement.scolaire.ml.confFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Users;

public class ConfigurationFileDataBase {
	public static boolean isExcelFile(MultipartFile file) {
		String context = file.getContentType();
		return (context.equals("application/vnd.ms-excel"))?true:false;
	}
	public static List<Etudiant> CreateDatabaseEtudiant(InputStream os) {
		List<Etudiant> liste = new ArrayList<>();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getSheet("data");
		int ligneNum = 0;
		Iterator<Row> ligne = sheet.iterator();
		while(ligne.hasNext()) {
			Row row = ligne.next();
			if(ligneNum == 0) {
				ligneNum++;
				continue;
			}
			Iterator<Cell> cells = row.iterator(); 
			int cible = 0;
			Etudiant etudiant = new Etudiant();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				switch(cible) {
				case 0:
					etudiant.setId(Double.doubleToLongBits(cell.getNumericCellValue()));
					break;
				case 1:
					etudiant.setNom(cell.getStringCellValue());
					break;
				case 2:
					etudiant.setPrenom(cell.getStringCellValue());
					break;
				case 3:
					etudiant.setAdresse(cell.getStringCellValue());
					break;
				case 4:
					etudiant.setMatricule(cell.getStringCellValue());
					break;
				case 5:
					etudiant.setNumeroMatricule(cell.getStringCellValue());
					break;
				case 6:
					etudiant.setEmail(cell.getStringCellValue());
					break;
				
				default:
					break;
				}
				cible++;
			}
			liste.add(etudiant);
		}
		return liste;
	}
	@SuppressWarnings("resource")
	public static List<Users> createDataBaseUsers(InputStream os){
		List<Users> liste = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getSheet("data");
		
		Iterator<Row> ligne = sheet.iterator();
		int ligneNum = 0;
		while(ligne.hasNext()) {
			Row row = ligne.next();
			if(ligneNum == 0) {
				ligneNum ++;
				continue;
			}
			Iterator<Cell> cell = row.iterator();
			int cible = 0;
			Users users = new Users();
			while(cell.hasNext()) {
				Cell cells = cell.next();
			switch(cible) {
			case 0:
				users.setId(Double.doubleToLongBits(cells.getNumericCellValue()));
				break;
			case 1:
				users.setNom(cells.getStringCellValue());
				break;
			case 2:
				users.setPrenom(cells.getStringCellValue());
				break;
			case 3:
				users.setAdresse(cells.getStringCellValue());
				break;
			case 4:
				users.setEmail(cells.getStringCellValue());
				break;
			case 5:
				users.setDateNaissance(cells.getDateCellValue());
				break;
				default:
					break;
			}
			cible ++;
			}
			liste.add(users);
		}
		return liste;
	}
}

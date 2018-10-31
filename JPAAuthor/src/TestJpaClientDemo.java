import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.Author;

import com.cg.dao.AuthorDaoImpl;


public class TestJpaClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorDaoImpl autDao = new AuthorDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter author Id :");
		int aid = sc.nextInt();
		System.out.println("Enter First name :");
		String fnm = sc.next();
		System.out.println("Enter Middle name :");
		String mnm = sc.next();
		System.out.println("Enter Last name :");
		String lnm = sc.next();
		System.out.println("Enter Mobile no :");
		String phn = sc.next();

		Author at = new Author();
		at.setAuthorId(aid);
		at.setFirstName(fnm);
		at.setMiddleName(mnm);
		at.setLastName(lnm);
		at.setPhoneNo(phn);
		Author aut = autDao.addAuthor(at);
		System.out.println("Data Inserted in the table"+aut);
		System.out.println("Retrieve Author based on AuthorId");
		List<Author> author = autDao.getAuthorById(108);
		System.out.println(author);
		System.out.println("Retrieve all data and display");
		List<Author> atList = autDao.getAllAuthors();
		Iterator<Author> it = atList.iterator();
		System.out.println("RollNo\tFirstName\tMiddleName\tLastName\tPhoneNo");
		System.out.println("-------------------");
		while(it.hasNext()){
			Author tempAut = it.next();
			System.out.println(tempAut.getAuthorId()+"\t\t"+tempAut.getFirstName()+"\t\t"+tempAut.getMiddleName()+"\t\t"+tempAut.getLastName()+"\t\t"+tempAut.getPhoneNo());
		}
		
		System.out.println("Deleted record 2");
		System.out.println("Record deleted for :"+autDao.deleteAuthor(2));
		
		System.out.println("Update Name");
		Author at3 = autDao.updateAuthorName(111, "Panga", "Swetha", "Reddy", "8121147388");
		System.out.println("Updated : "+at3);
		
		System.out.println("get author by Id");
		List <Author> at4 = autDao.getAuthorById(111);
		System.out.println(at4);
		
	}

}

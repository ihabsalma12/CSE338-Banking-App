package sourceFiles;

import java.io.*;
import java.util.*;

public class Bank {
	private Map<String,UserAccount> userlist;

	public Bank(){
		this.userlist = new HashMap<>();
	}

	public void addAccount(UserAccount user) {
		// TODO Auto-generated method stub
		this.userlist.put(user.getUserName(),user);

	}
	public void removeAccount(String string) {
		// TODO Auto-generated method stub
		this.userlist.remove(string);

	}
	public Map<String,UserAccount> getUserList() {
		// TODO Auto-generated method stub
		return this.userlist;

	}

	public UserAccount getAccount(String string) {
		// TODO Auto-generated method stub
		return this.userlist.get(string);

	}
	public void serializeDataOut()throws IOException{
		File fileOne=new File("userlist");
		FileOutputStream fos=new FileOutputStream(fileOne);
		ObjectOutputStream oos=new ObjectOutputStream(fos);

		oos.writeObject(this.userlist);
		oos.flush();
		oos.close();
		fos.close();
	}
	public void serializeDataIn() throws Exception{
		File toRead=new File("userlist");
		FileInputStream fis=new FileInputStream(toRead);
		ObjectInputStream ois=new ObjectInputStream(fis);

		this.userlist=(HashMap<String,UserAccount>)ois.readObject();

		ois.close();
		fis.close();

	}
	public void updateAccount(UserAccount user){
		this.userlist.replace(user.getUserName(),user);
	}

}

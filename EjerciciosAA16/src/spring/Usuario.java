package spring;

public class Usuario extends Persona{

	private String UserId;
	private String Useremail;
	
	public Usuario(String UserId,String nombre,String Useremail) {
		super(nombre);
		this.UserId=UserId;
		this.Useremail=Useremail;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [UserId=" + UserId + ", Nombre=" + super.getNombre()  + ", Useremail=" + Useremail + "]" + "\n";
	}


	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUseremail() {
		return Useremail;
	}
	public void setUseremail(String useremail) {
		Useremail = useremail;
	}
	
}

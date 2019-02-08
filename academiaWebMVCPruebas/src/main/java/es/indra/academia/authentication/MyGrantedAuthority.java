package es.indra.academia.authentication;


import org.springframework.security.core.GrantedAuthority;

public class MyGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -3437836241406811250L;
	private String authority = null;

	public MyGrantedAuthority(String authority) { this.authority = authority; }
	public String getAuthority() { return authority; }
}

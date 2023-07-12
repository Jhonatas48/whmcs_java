package br.jhonatastomaz.interfaces.managers;

import java.util.List;

import br.jhonatastomaz.interfaces.IUser;

public interface IUserManager {

	public List<IUser>getUsers();
	public IUser getUserByEmail(String email);
	public IUser getUserById(int id);
}

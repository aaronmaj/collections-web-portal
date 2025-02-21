package com.payment.epg.portal.controller;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.security.NoSuchAlgorithmException;

@ManagedBean(name = "signupBean")
public class SignUpBean {
	private String signUpName;
	private String signUpEmail;
	private String signUpPassword;
	private String signUpPasswordRepeat;
	private boolean isCreateAccount;

	public SignUpBean() {

	}

	public String getSignUpName() {
		return signUpName;
	}

	public void setSignUpName(String signUpName) {
		this.signUpName = signUpName;
	}

	public String getSignUpEmail() {
		return signUpEmail;
	}

	public void setSignUpEmail(String signUpEmail) {
		this.signUpEmail = signUpEmail;
	}

	public String getSignUpPassword() {
		return signUpPassword;
	}

	public void setSignUpPassword(String signUpPassword) {
		this.signUpPassword = signUpPassword;
	}

	public String getSignUpPasswordRepeat() {
		return signUpPasswordRepeat;
	}

	public void setSignUpPasswordRepeat(String signUpPasswordRepeat) {
		this.signUpPasswordRepeat = signUpPasswordRepeat;
	}

	public boolean getIsCreateAccount() {
		return isCreateAccount;
	}

	public void setIsCreateAccount(boolean isCreateAccount) {
		this.isCreateAccount = isCreateAccount;
	}

	public void userSignUp() throws NoSuchAlgorithmException {

		System.out.println(isCreateAccount);
		if (!(signUpPassword.equals(signUpPasswordRepeat))) {
			RequestContext.getCurrentInstance().update("growl");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					" Validation Error: Password and Repeat-Password not equal !", ""));
			return;
		}

		if (!isCreateAccount) {
			RequestContext.getCurrentInstance().update("growl");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					" Validation Error: Terms & Conditions not checked", ""));
			return;
		}

		boolean isSignUpSucessful = false;
		/*try {
			String signUpHash = Mysql.getHashValue(signUpPassword);
			 Boolean status = Mysql.insertQuery(signUpName, signUpEmail, signUpHash);
			if (status) {
				isSignUpSucessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isSignUpSucessful) {
			RequestContext.getCurrentInstance().update("growl");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful: Acccount created ! " + signUpEmail, ""));
			clear();
		} else {
			RequestContext.getCurrentInstance().update("growl");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Creating account !", ""));
		}

		return;
		*/
	}

	public void clear() {
		setSignUpName(null);
		setSignUpEmail(null);
		setSignUpPassword(null);
		setSignUpPasswordRepeat(null);
		setIsCreateAccount(false);
	}
}

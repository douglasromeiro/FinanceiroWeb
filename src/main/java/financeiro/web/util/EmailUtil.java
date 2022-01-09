package financeiro.web.util;

import java.util.Properties;

import javax.mail.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import financeiro.util.UtilException;



public class EmailUtil {

	public void enviarEmail(String de, String para, String assunto, String mensagem) throws UtilException {
			try {
				Context initialContext = new InitialContext();
				Context envContext = (Context) initialContext.lookup("java:comp/env");
				Session sessao =  (Session) envContext.lookup("mail/Session");
				SimpleEmail email = new SimpleEmail();
				email.setMailSession(sessao);
				if(de != null) {
					email.setFrom(de);
				}else{
					Properties p = sessao.getProperties();
					email.setFrom(p.getProperty("mail.smtp.user"));
				}
				email.addTo(para);
				email.setSubject(assunto);
				email.setMsg(mensagem);
				email.send();
			} catch (EmailException e) {
				throw new UtilException(e);
			} catch (NamingException e) {
				throw new UtilException(e);
			}
		}
}

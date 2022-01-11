package financeiro.webservice;

public interface FinanceiroWSService extends javax.xml.rpc.Service {
    public java.lang.String getFinanceiroWSPortAddress();

    public financeiro.webservice.FinanceiroWS getFinanceiroWSPort() throws javax.xml.rpc.ServiceException;

    public financeiro.webservice.FinanceiroWS getFinanceiroWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

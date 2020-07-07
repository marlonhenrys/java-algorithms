package interfaces;

import java.io.IOException;

public interface Entidade {

	public void setId(int codigo);

	public int getId();

	public byte[] getByteArray() throws IOException;

	public void setByteArray(byte[] b) throws IOException;

}

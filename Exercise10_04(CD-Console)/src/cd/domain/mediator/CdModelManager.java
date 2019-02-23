package cd.domain.mediator;

import java.io.IOException;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdModelManager implements CdModel {
	private CdList list;
	private CdPersistence persistence;
	
	public CdModelManager() throws IOException
	{
		persistence = new CdTextFile("src/cds.txt");
        list = persistence.load();
	}

	@Override
	public CdList getAll() {
		return list;
	}

	@Override
	public void addCD(Cd cd) {
		list.addCd(cd);
		
	}

	@Override
	public Cd removeCD(String title) {
		return list.removeFirstCdByTitle(title);
	}

	@Override
	public Cd getCD(int index) {
		return list.getCD(index);
	}

	@Override
	public CdList getCDds(String title) {
		return list.getCdsByTitle(title);
	}

	@Override
	public int getNumberOfCDs() {
		return list.getNumberOfCds();
	}
	
}

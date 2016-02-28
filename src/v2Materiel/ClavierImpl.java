package v2Materiel;

import version2.View;

public class ClavierImpl implements Clavier{

	
	View view;
	
	public boolean start=false;
	public boolean stop=false;
	public boolean inc=false;
	public boolean dec=false;
	
	public ClavierImpl(View view){
		this.view=view;
	}
	
	public boolean touchePres(int i) {
	   if (i==0) return start;
	   if (i==1) return stop;
	   if (i==2) return inc;
	   else  return dec ;
		
	}

    
    public void appuyer(int i) {
        switch (i) {
            case 0:
                start=true;
                break;
            case 1:
                stop=true;
                break;
            case 2:
                inc=true;
                break;
            case 3:
                dec=true;
                break;
        }
    }

    
    public void relacher(int i) {
        switch (i) {
            case 0:
                start=false;
                break;
            case 1:
                stop=false;
                break;
            case 2:
                inc=false;
                break;
            case 3:
                dec=false;
                break;
        }
    }
	


}

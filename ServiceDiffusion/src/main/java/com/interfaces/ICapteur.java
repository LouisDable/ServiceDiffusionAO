package com.interfaces;

import java.util.ArrayList;

public interface ICapteur extends ISujetObserve{
	public ArrayList<IObservateur> getObservateur();
	public Integer getValue();
	public void tick();
}

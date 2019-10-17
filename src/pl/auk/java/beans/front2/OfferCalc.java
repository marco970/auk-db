package pl.auk.java.beans.front2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import pl.auk.back.OfferEnti;

public class OfferCalc {

	public OfferCalc()	{		
	}
	
	public List<OfferEnti> getOfferEntiList(List<OfferRaw> step)	{

		List<OfferEnti> stepList  = new ArrayList<>();
		
		Collections.sort(step);

		for(int j = 0; j<step.size()-1; j++)	{
			int pos = j+1;
			if (step.get(j).getCena()==step.get(j+1).getCena())	{
				pos++;
			}
			System.out.println(step.get(j).toString()+" pos2 "+pos);
			OfferEnti oe = new OfferEnti(
					step.get(j).getStepNr(),
					step.get(j).getOferent(),
					step.get(j).getCena(),
					pos);
			stepList.add(oe);
		}
		System.out.println(step.get(step.size()-1).toString()+" pos2 "+step.size());
		OfferEnti oe = new OfferEnti(
				step.get(step.size()-1).getStepNr(),
				step.get(step.size()-1).getOferent(),
				step.get(step.size()-1).getCena(),
				step.size());
		stepList.add(oe);
		
		return stepList;
	}
}

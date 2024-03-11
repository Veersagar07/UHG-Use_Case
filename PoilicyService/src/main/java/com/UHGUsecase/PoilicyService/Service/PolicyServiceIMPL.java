package com.UHGUsecase.PoilicyService.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.awt.Color;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUsecase.PoilicyService.Entity.Policy;
import com.UHGUsecase.PoilicyService.Repository.PolicyRepo;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PolicyServiceIMPL implements PolicyService {

	@Autowired
	private PolicyRepo policyRepo;

		
	@Override
	public String savePolicy(Policy policy) {
		Policy existingPolicyCheck =policyRepo.findByPolicyName(policy.getPolicyName());
		if (existingPolicyCheck == null) {
			policyRepo.save(policy);
			return "Policy added";
		} else {
			return "Already exists";
		}

	}

	@Override
	public Policy findByPolicyName(String policy_name) {
		return policyRepo.findByPolicyName(policy_name);
		
	}
	
	@Override
	public List<Policy> getAllPolicies() {
		return policyRepo.findAll();
	}
	
	@Override
	public void updatePolicy(Policy policy) {
		policyRepo.save(policy);
	}

	@Override
	public void deletePolicy(long id) {
		policyRepo.deleteById((int) id);
		
	}

	@Override
	public List<Policy> findByPolicyId(long policyId) {
		return policyRepo.findByPolicyId(policyId);
	}
	
	@Override
	public List<Policy> findAll(){
		return policyRepo.findAll();
	}
	
	@Override
	public ByteArrayInputStream generatePolicyPdf(Policy policy) {
		
		String title="Health Insurance";
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		Document document=new Document();
		PdfWriter.getInstance(document, outputStream);
		document.open();
		try {		
			
			Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
			Paragraph titleParagraph = new Paragraph(title,font);
			titleParagraph.setAlignment(Element.ALIGN_CENTER);
			document.add(titleParagraph);
			document.add(new Paragraph(" "));
			
			
			
			PdfPTable table=new PdfPTable(2);
			table.setHeaderRows(1);
			table.getDefaultCell().setBackgroundColor(new Color(192, 192, 192));
			table.addCell("Attributes");
			table.addCell("Values");
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			Font tableFont=FontFactory.getFont(FontFactory.HELVETICA,10);
			PdfPCell policyName=new PdfPCell(new Phrase("Policy Name ", tableFont));
			policyName.setBackgroundColor(new Color(192, 192, 192));
			policyName.setPadding(8);
			table.addCell(policyName);
			
			PdfPCell policyNameValue=new PdfPCell(new Phrase(policy.getPolicyName(), tableFont));
			policyNameValue.setBackgroundColor(new Color(192, 192, 192));
			policyNameValue.setPadding(8);
			table.addCell(policyNameValue);
			
			PdfPCell policyDescription=new PdfPCell(new Phrase("Policy Description ", tableFont));
			policyDescription.setBackgroundColor(new Color(192, 192, 192));		
			policyDescription.setPadding(8);
			table.addCell(policyDescription);
			
			PdfPCell policyDescriptionValue=new PdfPCell(new Phrase(policy.getDescription(), tableFont));
			policyDescriptionValue.setBackgroundColor(new Color(192, 192, 192));
			policyDescriptionValue.setPadding(8);
			table.addCell(policyDescriptionValue);
			
		
			PdfPCell policyHolderMaximumAge=new PdfPCell(new Phrase("Policy Holder Maximum Age", tableFont));
			policyHolderMaximumAge.setBackgroundColor(new Color(192, 192, 192));		
			policyHolderMaximumAge.setPadding(8);
			table.addCell(policyHolderMaximumAge);
			
			PdfPCell policyHolderMaximumAgeValue=new PdfPCell(new Phrase(policy.getMaxAge()+""));
			policyHolderMaximumAgeValue.setBackgroundColor(new Color(192, 192, 192));
			policyHolderMaximumAgeValue.setPadding(8);
			table.addCell(policyHolderMaximumAgeValue);
			
			PdfPCell policyHolderMinimunAge=new PdfPCell(new Phrase("Policy Holder Minimum Age", tableFont));
			policyHolderMinimunAge.setBackgroundColor(new Color(192, 192, 192));		
			policyHolderMinimunAge.setPadding(8);
			table.addCell(policyHolderMinimunAge);
			
			PdfPCell policyHolderMinimunAgeValue=new PdfPCell(new Phrase(policy.getMinAge()+""));
			policyHolderMinimunAgeValue.setBackgroundColor(new Color(192, 192, 192));
			policyHolderMinimunAgeValue.setPadding(8);
			table.addCell(policyHolderMinimunAgeValue);
			
			PdfPCell policyPremiumAmount=new PdfPCell(new Phrase("Policy Premium Amount", tableFont));
			policyPremiumAmount.setBackgroundColor(new Color(192, 192, 192));		
			policyPremiumAmount.setPadding(8);
			table.addCell(policyPremiumAmount);
			
			PdfPCell policyPremiumAmountValue=new PdfPCell(new Phrase(policy.getPremiumAmount()+""));
			policyPremiumAmountValue.setBackgroundColor(new Color(192, 192, 192));
			policyPremiumAmountValue.setPadding(8);
			table.addCell(policyPremiumAmountValue);
			
			PdfPCell policyCoverAmount=new PdfPCell(new Phrase("Policy Cover Amount", tableFont));
			policyCoverAmount.setBackgroundColor(new Color(192, 192, 192));		
			policyCoverAmount.setPadding(8);
			table.addCell(policyCoverAmount);
			
			PdfPCell policyCoverAmountValue=new PdfPCell(new Phrase(policy.getPolicyCoverAmount()+""));
			policyCoverAmountValue.setBackgroundColor(new Color(192, 192, 192));
			policyCoverAmountValue.setPadding(8);
			table.addCell(policyCoverAmountValue);
			
			PdfPCell policyRenewal=new PdfPCell(new Phrase("Policy Renewal", tableFont));
			policyRenewal.setBackgroundColor(new Color(192, 192, 192));		
			policyRenewal.setPadding(8);
			table.addCell(policyRenewal);
			
			PdfPCell policyRenewalValue=new PdfPCell(new Phrase(policy.getRenewalTerm(),tableFont));
			policyRenewalValue.setBackgroundColor(new Color(192, 192, 192));
			policyRenewalValue.setPadding(8);
			table.addCell(policyRenewalValue);
			
			
			PdfPCell policyCoPay=new PdfPCell(new Phrase("Policy Co-Pay", tableFont));
			policyCoPay.setBackgroundColor(new Color(192, 192, 192));		
			policyCoPay.setPadding(8);
			table.addCell(policyCoPay);
			
			PdfPCell policyCoPayValue=new PdfPCell(new Phrase(policy.getCoPay()+"%"));
			policyCoPayValue.setBackgroundColor(new Color(192, 192, 192));
			policyCoPayValue.setPadding(8);
			table.addCell(policyCoPayValue);
			
			document.add(table);
			document.close(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	return new ByteArrayInputStream(outputStream.toByteArray());
	}
	

}

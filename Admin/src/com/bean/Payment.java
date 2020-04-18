package com.bean;

public class Payment {
	

		private int paymentID;
		private String paymentType;
		private Double paymentAmount;
		private int appointmentID;
		
		

		public Payment() {
			super();
		}

		public Payment(int paymentID, String paymentType, Double paymentAmount, int appointmentID) {
			super();
			this.paymentID = paymentID;
			this.paymentType = paymentType;
			this.paymentAmount = paymentAmount;
			this.appointmentID = appointmentID;
		}

		public int getPaymentID() {
			return paymentID;
		}

		public void setPaymentID(int paymentID) {
			this.paymentID = paymentID;
		}

		public String getPaymentType() {
			return paymentType;
		}

		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		public Double getPaymentAmount() {
			return paymentAmount;
		}

		public void setPaymentAmount(Double paymentAmount) {
			this.paymentAmount = paymentAmount;
		}

		public int getAppointmentID() {
			return appointmentID;
		}

		public void setAppointmentID(int appointmentID) {
			this.appointmentID = appointmentID;
		}

		
		
		@Override
		public String toString() {
			return "Payments [paymentID=" + paymentID + ", paymentType=" + paymentType + ", paymentAmount=" + paymentAmount
					+ ", appointmentID=" + appointmentID + "]";
		}
	}



package com.revature.project0.exceptions;

/*
 * Since no user input should produce an invalid transaction, this exception indicates to me that some part of the code
 * needs fixing to ensure that only valid transaction types are attempted to be added
 */
public class InvalidBankTransactionException extends RuntimeException {

	private static final long serialVersionUID = -4904735259789919761L;
}

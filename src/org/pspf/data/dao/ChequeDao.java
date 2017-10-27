package org.pspf.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pspf.data.CallManagerBank;
import org.pspf.data.interfaces.IChequeDAO;
import org.pspf.exceptions.MysqlException;
import org.pspf.model.dto.BranchDTO;
import org.pspf.model.dto.ChequeModal;
import org.pspf.services.PspfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChequeDao extends BaseDao implements IChequeDAO {

	private Logger logger = LoggerFactory.getLogger(PspfService.class);

	private static final String ALL_CHEQUE = "SELECT * FROM pspf_contributions, pspf_cheque WHERE pspf_contributions.id = pspf_cheque.id AND pspf_contributions.status = 100";
	private static final String ALL_CHEQUE_BY_STATE = "SELECT * FROM pspf_contributions, pspf_cheque WHERE pspf_contributions.id = pspf_cheque.id AND pspf_contributions.status = ?";
	private static final String REJECT = "SELECT * FROM pspf_contributions, pspf_cheque WHERE pspf_contributions.id = pspf_cheque.id AND pspf_contributions.status = 101 OR pspf_contributions.status = 201";
	private static final String UPDATE_STATE = "UPDATE pspf_contributions JOIN pspf_cheque ON pspf_contributions.id = pspf_cheque.id AND pspf_cheque.cheque_no=? SET pspf_contributions.status=?";

	@Override
	public List<ChequeModal> getChequeList() {
		logger.info("all cheque dao executed ");

		Connection dbConn = getConnection();
		List<ChequeModal> chequeList = new ArrayList<ChequeModal>();

		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_CHEQUE);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ChequeModal cheque = new ChequeModal();
				cheque.setId(result.getLong("id"));
				cheque.setAmount(result.getDouble("amount"));
				cheque.setChequeDate(result.getString("cheque_date"));
				cheque.setChequeNumber(result.getString("cheque_no"));
				cheque.setInstitute(result.getString("pensionpoint_id"));

				WebTarget target = CallManagerBank.getRootTarget().path(result.getString("branch_id"));

				Response response = target.request(MediaType.APPLICATION_JSON).get();

				if (response.getStatus() != Response.Status.OK.getStatusCode()) {
					logger.info("Bank Not Found.");

				} else {
					BranchDTO branch = response.readEntity(BranchDTO.class);
					cheque.setBranch(branch);
				}

				chequeList.add(cheque);
			}

		} catch (Exception e) {
			throw new MysqlException(e);

		} finally {
			closeConnection(dbConn);

		}

		return chequeList;
	}

	@Override
	public List<ChequeModal> getChequeListByState(int state) {
		logger.info("all cheque dao executed ");

		Connection dbConn = getConnection();
		List<ChequeModal> chequeList = new ArrayList<ChequeModal>();

		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_CHEQUE_BY_STATE);
			ps.setInt(1, state);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ChequeModal cheque = new ChequeModal();
				cheque.setId(result.getLong("id"));
				cheque.setAmount(result.getDouble("amount"));
				cheque.setChequeDate(result.getString("cheque_date"));
				cheque.setChequeNumber(result.getString("cheque_no"));
				cheque.setInstitute(result.getString("pensionpoint_id"));

				WebTarget target = CallManagerBank.getRootTarget().path(result.getString("branch_id"));

				Response response = target.request(MediaType.APPLICATION_JSON).get();

				if (response.getStatus() != Response.Status.OK.getStatusCode()) {
					logger.info("Bank Not Found.");

				} else {
					BranchDTO branch = response.readEntity(BranchDTO.class);
					cheque.setBranch(branch);
				}

				chequeList.add(cheque);
			}

		} catch (Exception e) {
			throw new MysqlException(e);

		} finally {
			closeConnection(dbConn);

		}

		return chequeList;
	}

	@Override
	public List<ChequeModal> getRejectChequeList() {
		logger.info("all cheque dao executed ");

		Connection dbConn = getConnection();
		List<ChequeModal> chequeList = new ArrayList<ChequeModal>();

		try {
			PreparedStatement ps = dbConn.prepareStatement(REJECT);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ChequeModal cheque = new ChequeModal();
				cheque.setId(result.getLong("id"));
				cheque.setAmount(result.getDouble("amount"));
				cheque.setChequeDate(result.getString("cheque_date"));
				cheque.setChequeNumber(result.getString("cheque_no"));
				cheque.setInstitute(result.getString("pensionpoint_id"));

				WebTarget target = CallManagerBank.getRootTarget().path(result.getString("branch_id"));

				Response response = target.request(MediaType.APPLICATION_JSON).get();

				if (response.getStatus() != Response.Status.OK.getStatusCode()) {
					logger.info("Bank Not Found.");

				} else {
					BranchDTO branch = response.readEntity(BranchDTO.class);
					cheque.setBranch(branch);
				}

				chequeList.add(cheque);
			}

		} catch (Exception e) {
			throw new MysqlException(e);

		} finally {
			closeConnection(dbConn);

		}

		return chequeList;
	}

	/**
	 * change state
	 */
	@Override
	public Boolean updateState(int state, String chequeNo) {

		logger.info("update state");
		Connection dbConn = getConnection();

		try {
			PreparedStatement ps = null;
			ps = dbConn.prepareStatement(UPDATE_STATE);
			ps.setString(1, chequeNo);
			ps.setInt(2, state);
			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new MysqlException(e);
		} finally {
			closeConnection(dbConn);
		}

	}

}

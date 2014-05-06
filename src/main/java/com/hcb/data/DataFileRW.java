package com.hcb.data;

/**
 * Create, remove, update and query in data file<br />
 * 
 * @author range
 * @param <T>
 * 
 */
public interface DataFileRW<T> {

	/**
	 * Create a new record in the memory<br />
	 * 
	 * @param <T>
	 * 
	 * @param record
	 *            data for record creating
	 * @return is the record created successfully
	 */
	boolean create(T record);

	/**
	 * Update the record in the memory<br />
	 * 
	 * @param id
	 *            record ID
	 * @param record
	 * @return is the record modified successfully
	 */
	boolean update(String id, T record);

	/**
	 * Remove a record in the memory<br />
	 * 
	 * @param id
	 *            record ID
	 * @return is the record removed successfully
	 */
	boolean remove(String id);

	/*
	 * boolean batchModify(List<Map<Object, Object>> info, Object... params);
	 */

	/*
	 * boolean batchRemove(List<Map<Object, Object>> info, Object... params);
	 */

	/**
	 * Query from the memory<br />
	 * 
	 * @param id
	 *            record ID
	 * @return query results
	 */
	T query(String id);

	/*
	 * List<Map<Object, Object>> batchQuery(List<Map<Object, Object>> info);
	 */

	/**
	 * Query all records from the memory<br />
	 * 
	 * @return query results
	 */
	T queryAll();
}

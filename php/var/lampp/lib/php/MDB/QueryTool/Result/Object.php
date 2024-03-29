<?php
/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * Contains the MDB_QueryTool_Result_Row and MDB_QueryTool_Result_Object classes
 *
 * PHP versions 4 and 5
 *
 * LICENSE: This source file is subject to version 3.0 of the PHP license
 * that is available through the world-wide-web at the following URI:
 * http://www.php.net/license/3_0.txt.  If you did not receive a copy of
 * the PHP License and are unable to obtain it through the web, please
 * send a note to license@php.net so we can mail you a copy immediately.
 *
 * @category   Database
 * @package    MDB_QueryTool
 * @author     Roman Dostovalov, Com-tec-so S.A.<roman.dostovalov@ctco.lv>
 * @copyright  2004-2005 Roman Dostovalov
 * @license    http://www.php.net/license/3_0.txt  PHP License 3.0
 * @version    CVS: $Id: Object.php,v 1.2 2005/02/25 15:43:31 quipo Exp $
 * @link       http://pear.php.net/package/MDB_QueryTool
 */

/**
 * Include parent class
 */
require_once 'MDB/QueryTool/Result.php';

/**
 * MDB_QueryTool_Result_Row class
 *
 * @category   Database
 * @package    MDB_QueryTool
 * @author     Roman Dostovalov, Com-tec-so S.A.<roman.dostovalov@ctco.lv>
 * @copyright  2004-2005 Roman Dostovalov
 * @license    http://www.php.net/license/3_0.txt  PHP License 3.0
 * @link       http://pear.php.net/package/MDB_QueryTool
 */
class MDB_QueryTool_Result_Row
{
	/**
	 * create object properties from the array
	 * @param array
	 */
	function MDB_QueryTool_Result_Row($arr)
	{
        foreach ($arr as $key => $value) {
		    $this->$key = $value;
        }
	}
}

// -----------------------------------------------------------------------------

/**
 * MDB_QueryTool_Result_Object class
 *
 * @category   Database
 * @package    MDB_QueryTool
 * @author     Roman Dostovalov, Com-tec-so S.A.<roman.dostovalov@ctco.lv>
 * @copyright  2004-2005 Roman Dostovalov
 * @license    http://www.php.net/license/3_0.txt  PHP License 3.0
 * @link       http://pear.php.net/package/MDB_QueryTool
 */
class MDB_QueryTool_Result_Object extends MDB_QueryTool_Result
{
    // {{{ fetchRow

	/**
	 * This function emulates PEAR::MDB fetchRow() method
	 * With this function MDB_QueryTool can transparently replace PEAR::MDB
	 *
	 * @todo implement fetchmode support?
	 * @access    public
	 * @return    void
	 */
	function fetchRow()
	{
		$arr = $this->getNext();
		if (!PEAR::isError($arr)) {
		    $row = new MDB_QueryTool_Result_Row($arr);
			return $row;
		}
		return false;
	}

	// }}}
}
?>
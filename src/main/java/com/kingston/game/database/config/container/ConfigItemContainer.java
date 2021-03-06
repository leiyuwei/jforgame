package com.kingston.game.database.config.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kingston.game.database.config.Reloadable;
import com.kingston.game.database.config.bean.ConfigItem;
import com.kingston.orm.utils.DbUtils;

public class ConfigItemContainer implements Reloadable {

	private Map<Integer, ConfigItem> items = new HashMap<>();

	@Override
	public void reload() {
		String sql = "SELECT * FROM ConfigItem";
		List<ConfigItem> datas = DbUtils.queryMany(DbUtils.DB_DATA, sql, ConfigItem.class);

		items = datas.stream().collect(
				Collectors.toMap(ConfigItem::getModelId, Function.identity()));
	}

	public ConfigItem getItemBy(int modelId) {
		return items.get(modelId);
	}

}

/*
 * Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2014 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.fragment.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import org.mariotaku.twidere.adapter.CursorStatusesListAdapter;
import org.mariotaku.twidere.provider.TweetStore.Statuses;

/**
 * Created by mariotaku on 14/12/3.
 */
public class HomeTimelineFragment extends CursorStatusesFragment {
    @Override
    public int getStatuses(long[] accountIds, long[] maxIds, long[] sinceIds) {
        return 0;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        final Context context = getActivity();
        final Uri uri = Statuses.CONTENT_URI;
        final SharedPreferences preferences = getSharedPreferences();
        final boolean sortById = preferences.getBoolean(KEY_SORT_TIMELINE_BY_ID, false);
        final String sortOrder = sortById ? Statuses.SORT_ORDER_STATUS_ID_DESC : Statuses.SORT_ORDER_TIMESTAMP_DESC;
        return new CursorLoader(context, uri, CursorStatusesListAdapter.CURSOR_COLS, null, null, sortOrder);
    }
}

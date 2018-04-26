import { BASE_URL } from './base';

const createFav = async (bookId, userId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}&user=${userId}`, {
      method: 'POST',
    });

    const data = await response.json();

    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

const deleteFav = async (bookId, userId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}&user=${userId}`, {
      method: 'DELETE',
    });

    const data = await response.json();

    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

const getFav = async (bookId, userId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}&user=${userId}`, {
      method: 'GET',
    });

    const data = await response.json();

    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

const countFav = async (bookId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}`, {
      method: 'GET',
    });

    const data = await response.json();

    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

export default {
  getFav,
  countFav,
  createFav,
  deleteFav,
};
